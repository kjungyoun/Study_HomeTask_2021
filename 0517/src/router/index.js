import Vue from "vue";
import VueRouter from "vue-router";
import Create from "@/components/Create";
import Index from "@/components/Index";
import List from "@/components/List";
import Search from "@/components/Search";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Index",
    component: Index,
  },
  {
    path: "/list",
    name: "List",
    component: List,
  },
  {
    path: "/create",
    name: "Create",
    component: Create,
  },
  {
    path: "/search",
    name: "Search",
    component: Search,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
