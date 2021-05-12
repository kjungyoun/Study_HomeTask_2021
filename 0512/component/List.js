export default {
  template: `<div >
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
    <div v-if="member.length>0">
      <table class="table table-hover">
        <thead>
          <tr class="bg-info text-light">
            <th>사원아이디</th>
            <th>사원명</th>
            <th>부서</th>
            <th>직책</th>
            <th>연봉</th>
          </tr>
        </thead>
        <tbody>
          <!-- 검색한 결과가 아닐 경우 -->
          <tr v-for="mem in member">
            <td>{{mem.no}}</td>
            <td><a :href="'search.html?id='+mem.no">{{mem.name}}</a></td>
            <td v-text="mem.department"></td>
            <td v-text="mem.position"></td>
            <td v-text="mem.price"></td>
          </tr>
        </tbody>
      </table>
    </div>

    <!-- 검색 결과가 없거나 목록이 없을 경우 -->
    <div class="text-danger text-center" v-if="!(member.length>0)">
      <big>사원 정보가 없습니다.</big>
    </div>
  </div>
`,
  data() {
    return {
      member: [],
      src: [],
      name: "",
      isSearch: false,
    };
  },
  methods: {
    mvregist() {
      location.href = "create.html";
    },
    search() {
      // 검색할 결과를 담을 배열

      // 만약 검색어가 없을 때
      if (!this.name || this.name == "") {
        this.member = this.src;
      } else {
        // 검색어가 있다면
        this.member = this.src.filter((member) => {
          return member.name.includes(this.name);
        });
      }
    },
  },
  created() {
    const member = localStorage.getItem("member");
    let newMember = { sequence: 0, items: [] };
    if (member) {
      newMember = JSON.parse(member);
    } else {
      localStorage.setItem("member", newMember);
    }

    newMember.items.sort((a, b) => a.no - b.no);

    this.member = newMember.items;
    this.src = newMember.items;
  },
};
