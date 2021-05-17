<template>
  <div>
    <h2 class="text-info text-center">사원 목록</h2>
    <div class="input-group mb-3">
      <input
        type="text"
        class="form-control"
        placeholder="사원 이름 입력"
        v-model="name"
        v-on:keyup.enter="search"
      />
      <div class="input-group-append">
        <button class="btn btn-info" type="button" @click="search">검색</button>
      </div>
      <button class="btn btn-warning ml-3" type="button" @click="mvregist">등록</button>
    </div>
    <div v-if="members.length > 0">
      <table class="table table-hover">
        <thead>
          <tr class="bg-info text-light">
            <th>사원아이디</th>
            <th>사원명</th>
            <th>부서 번호</th>
            <th>직책</th>
            <th>연봉</th>
          </tr>
        </thead>
        <tbody>
          <!-- 검색한 결과가 아닐 경우 -->
          <tr v-for="(mem, idx) in members" :key="idx">
            <td>{{ mem.id }}</td>
            <td>
              <router-link :to="'/search?id=' + mem.id">{{ mem.name }}</router-link>
            </td>
            <td v-text="mem.dept_id"></td>
            <td v-text="mem.title"></td>
            <td v-text="mem.salary"></td>
          </tr>
        </tbody>
      </table>
    </div>

    <!-- 검색 결과가 없거나 목록이 없을 경우 -->
    <div class="text-danger text-center" v-if="!(members.length > 0)">
      <big>사원 정보가 없습니다.</big>
    </div>
  </div>
</template>
<script>
import { mapGetters } from "vuex";
export default {
  data() {
    return {
      name: "",
    };
  },
  computed: {
    ...mapGetters(["members"]),
  },
  methods: {
    mvregist() {
      this.$router.push("/create");
    },
    search() {
      // 검색할 결과를 담을 배열

      // 만약 검색어가 없을 때
      if (!this.name || this.name == "") {
        this.searchAll();
      } else {
        // 검색어가 있다면
        this.$store.dispatch(
          "getMembersByName",
          `http://localhost:8197/ssafyvue/api/findLikeEmployees/${this.name}`
        );
      }
    },
    searchAll() {
      this.$store.dispatch("getMembers");
    },
  },
  created() {
    this.searchAll();
  },
};
</script>
