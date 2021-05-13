export default {
  template: `
  <div>
    <h2 class="text-center">Vue를 이용한 게시판</h2>
    <table class="table table-condensed w-25" v-if="emp">
      <tr>
        <th>아이디</th>
        <td v-text="emp.id"></td>
      </tr>
      <tr>
        <th>이름</th>
        <td v-text="emp.name"></td>
      </tr>
      <tr>
        <th>이메일</th>
        <td v-text="emp.mailid"></td>
      </tr>
      <tr>
        <th>고용일</th>
        <td v-text="emp.start_date"></td>
      </tr>
      <tr>
        <th>관리자</th>
        <td v-text="manager"></td>
      </tr>
      <tr>
        <th>직책</th>
        <td v-text="emp.title"></td>
      </tr>
      <tr>
        <th>부서 번호</th>
        <td>{{dept_name}} ({{region_id}})</td>
      </tr>
      <tr>
        <th>월급</th>
        <td v-text="emp.salary"></td>
      </tr>
      <tr>
        <th>커미션</th>
        <td v-text="emp.commission_pct"></td>
      </tr>
    </table>
    <div class="text-right">
      <a class="btn btn-primary" href="list.html">목록</a>
    </div>
  </div>`,
  data() {
    return {
      emp: {},
      manager: "",
      dept_name: "",
      region_id: "",
    };
  },
  created() {
    const params = new URL(document.location).searchParams;
    let id;
    axios
      .get(`http://localhost:8197/ssafyvue/api/findEmployeeById/${params.get("id")}`)
      .then(({ data }) => {
        this.emp = data;

        // 관리자 이름 검색
        axios
          .get(`http://localhost:8197/ssafyvue/api/findEmployeeById/${data.manager_id}`)
          .then(({ data }) => {
            if (!data.name) {
              this.manager = "없음";
            } else {
              this.manager = data.name;
            }
          })
          .catch((err) => {
            alert("상사 이름 검색 중 오류발생");
          });
        // ---------------> 관리자 이름 검색 끝

        // 부서 이름 검색
        axios
          .get(`http://localhost:8197/ssafyvue/api/findAllDepartments`)
          .then(({ data }) => {
            for (let obj of data) {
              if (obj.dept_id == this.emp.dept_id) {
                this.dept_name = obj.name;
                this.region_id = obj.region_id;
              }
            }
          })
          .catch((err) => {
            alert("부서 이름 검색 오류발생");
          });
      })
      // ----------> 부서 이름 검색 끝

      .catch((err) => {
        alert("사원 상세 정보 조회중 오류 발생");
      });
  },
};
