<template>
  <div>
    <h2 class="text-center">Vue를 이용한 게시판</h2>
    <table class="table table-condensed w-25" v-if="member">
      <tr>
        <th>아이디</th>
        <td v-text="member.id"></td>
      </tr>
      <tr>
        <th>이름</th>
        <td v-text="member.name"></td>
      </tr>
      <tr>
        <th>이메일</th>
        <td v-text="member.mailid"></td>
      </tr>
      <tr>
        <th>고용일</th>
        <td v-text="member.start_date"></td>
      </tr>
      <tr>
        <th>관리자</th>
        <td v-text="member.manager_id"></td>
      </tr>
      <tr>
        <th>직책</th>
        <td v-text="member.title"></td>
      </tr>
      <tr>
        <th>부서 번호</th>
        <td>{{ member.dept_id }}</td>
      </tr>
      <tr>
        <th>월급</th>
        <td v-text="member.salary"></td>
      </tr>
      <tr>
        <th>커미션</th>
        <td v-text="member.commission_pct"></td>
      </tr>
    </table>
    <div class="text-right">
      <router-link class="btn btn-primary" to="/list">목록</router-link>
    </div>
  </div>
</template>
<script>
import { mapGetters } from "vuex";
export default {
  computed: {
    ...mapGetters(["member"]),
  },
  created() {
    this.$store.dispatch(
      "getMember",
      `http://localhost:8197/ssafyvue/api/findEmployeeById/${this.$route.query.id}`
    );
  },
};
</script>
