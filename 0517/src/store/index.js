import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    members: [],
    member: {},
  },
  getters: {
    members(state) {
      return state.members;
    },
    member(state) {
      return state.member;
    },
  },
  mutations: {
    SET_MEMBERS(state, payload) {
      state.members = payload;
    },
    SET_MEMBER(state, payload) {
      state.member = payload;
    },
    SET_MANAGER(state, payload) {
      state.member.manager_id = payload;
    },
  },
  actions: {
    getMembers({ commit }) {
      axios
        .get(`http://localhost:8197/ssafyvue/api/findAllEmployees`)
        .then(({ data }) => {
          commit("SET_MEMBERS", data);
        })
        .catch(() => {
          alert("오류 발생!!");
        });
    },
    getMembersByName({ commit }, payload) {
      axios
        .get(payload)
        .then(({ data }) => {
          commit("SET_MEMBERS", data);
        })
        .catch(() => {
          alert("오류 발생!!");
        });
    },
    getMember({ commit }, payload) {
      axios
        .get(payload)
        .then(({ data }) => {
          commit("SET_MEMBER", data);

          // 관리자 이름 검색
          axios
            .get(`http://localhost:8197/ssafyvue/api/findEmployeeById/${data.manager_id}`)
            .then(({ data }) => {
              if (!data.name) {
                commit("SET_MANAGER", "없음");
              } else {
                commit("SET_MANAGER", data.name);
              }
            })
            .catch(() => {
              alert("상사 이름 검색 중 오류발생");
            });
          // ---------------> 관리자 이름 검색 끝
        })

        .catch(() => {
          alert("사원 상세 정보 조회중 오류 발생");
        });
    },
  },
});
