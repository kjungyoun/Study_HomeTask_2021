export default {
  template: `<div>
  <h2 class="text-primary text-center">SSAFY HRM ADD EMPLOEE</h2>
  <table class="text-center table table-bordered">
    <tr>
      <td class="bg-primary text-light">이름</td>
      <td><input type="text" ref="name" v-model="name" /></td>
    </tr>
    <tr>
      <td class="bg-primary text-light">이메일</td>
      <td><input type="text" ref="email" v-model="email" /></td>
    </tr>
    <tr>
      <td class="bg-primary text-light">고용일</td>
      <td><input type="date" ref="regdate" v-model="regdate" /></td>
    </tr>
    <tr>
      <td class="bg-primary text-light">관리자</td>
      <td>
        <select ref="emp" v-model="emp">
          <option value="">없음</option>
          <option v-for="manager in managers" :value="manager.id">{{manager.name}}</option>
        </select>
      </td>
    </tr>
    <tr>
      <td class="bg-primary text-light">직책</td>
      <td>
        <select ref="position" v-model="position">
          <option value="사장">사장</option>
          <option value="기획부장">기획부장</option>
          <option value="영업부장">영업부장</option>
          <option value="총무부장">총무부장</option>
          <option value="인사부장">인사부장</option>
          <option value="과장">과장</option>
          <option value="영업대표이사">영업대표이사</option>
          <option value="사원">사원</option>
        </select>
      </td>
    </tr>

    <tr>
      <td class="bg-primary text-light">부서</td>
      <td>
        <select ref="department" v-model="department">
          <option value="110">기획부-1</option>
          <option value="111">기획부-2</option>
          <option value="112">기획부-3</option>
          <option value="113">기획부-4</option>
          <option value="102">영업부-1</option>
          <option value="103">영업부-2</option>
          <option value="104">영업부-3</option>
          <option value="105">영업부-4</option>
          <option value="106">영업부-5</option>
          <option value="118">인사부</option>
          <option value="101">총무부</option>
          <option value="120">회계부</option>
        </select>
      </td>
    </tr>
    <tr>
      <td class="bg-primary text-light">월급</td>
      <td><input type="text" ref="price" v-model="price" /></td>
    </tr>
    <tr>
      <td class="bg-primary text-light">커미션</td>
      <td><input type="text" ref="commission" v-model="commission" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <button type="button" class="btn-danger" @click="createMem">사원추가</button>
      </td>
    </tr>
  </table>
</div>`,
  data() {
    return {
      name: "",
      email: "",
      regdate: "",
      emp: "",
      position: "사원",
      department: "110",
      price: "",
      commission: "10",
      managers: [],
    };
  },
  created() {
    axios
      .get(`http://localhost:8197/ssafyvue/api/findAllEmployees`)
      .then(({ data }) => {
        this.managers = data;
      })
      .catch((err) => {
        alert("매니저 정보 조회중 에러 발생");
      });
  },

  methods: {
    createMem() {
      // 유효성 검사
      let err = false;
      let msg = "";

      if (this.name == "") {
        err = true;
        msg = "이름을 입력해주세요!";
        this.$refs.name.focus();
      } else if (this.email == "") {
        err = true;
        msg = "이메일을 입력하세요!";
        this.$refs.email.focus();
      } else if (this.regdate == "") {
        err = true;
        msg = "고용일을 입력하세요!";
        this.$refs.regdate.focus();
      } else if (this.emp == "") {
        err = true;
        msg = "관리자를 입력하세요!";
        this.$refs.email.focus();
      } else if (this.position == "") {
        err = true;
        msg = "직책을 입력하세요!";
        this.$refs.position.focus();
      } else if (this.department == "") {
        err = true;
        msg = "부서를 입력하세요!";
        this.$refs.department.focus();
      } else if (this.price == "") {
        err = true;
        msg = "월급을 입력하세요!";
        this.$refs.price.focus();
      } else if (this.commission == "") {
        err = true;
        msg = "커미션을 입력하세요";
        this.$refs.commission.focus();
      }

      if (err) {
        alert(msg);
      } else {
        axios
          .post(`http://localhost:8197/ssafyvue/api/addEmployee`, {
            name: this.name,
            mailid: this.email,
            start_date: this.regdate,
            manager_id: this.emp,
            title: this.position,
            dept_id: this.department,
            salary: this.price,
            commission_pct: this.commission,
          })
          .then(({ data }) => {
            if (data) {
              alert("등록 완료");
              location.href = `search.html?id=${data.count}`;
            }
          });
      }
    },
  },
};
