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
        <td v-text="emp.manager_id"></td>
      </tr>
      <tr>
        <th>직책</th>
        <td v-text="emp.title"></td>
      </tr>
      <tr>
        <th>부서</th>
        <td v-text="emp.dept_id"></td>
      </tr>
      <tr>
        <th>월급</th>
        <td v-text="emp.salary"></td>
      </tr>
      <tr>
        <th>커미션</th>
        <td v-text="emp.commision_pct"></td>
      </tr>
    </table>
    <div class="text-right">
      <a class="btn btn-primary" href="list.html">목록</a>
    </div>
  </div>`,
  data() {
    return {
      emp: {},
      id: "",
    };
  },
  created() {
    const params = new URL(document.location).searchParams;
    this.id = params.get("id");

    const emp = JSON.parse(localStorage.getItem("emps"));
    for (let obj of emp.items) {
      if (obj.id == this.id) {
        this.emp = obj;
        break;
      }
    }
  },
};
