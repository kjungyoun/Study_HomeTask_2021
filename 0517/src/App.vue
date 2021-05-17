<template>
  <div id="app">
    <nav-header></nav-header>
    <h2 class="text-center">Vuex를 이용한 웹페이지</h2>
    <router-view />
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>

<script>
import NavHeader from "@/components/NavHeader";
export default {
  name: "App",
  components: {
    NavHeader,
  },
};
</script>
