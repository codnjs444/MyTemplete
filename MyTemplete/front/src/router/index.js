import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '@/components/HomePage.vue';
import LoginPage from '@/layout/login/LoginPage.vue';
import JoinPage from '@/layout/login/JoinPage.vue';

const routes = [
  {
    path: '/',
    redirect: '/login'  // 기본 경로로 접속 시 /login으로 리디렉션
  },
  {
    path: '/home',
    name: 'home',
    component: HomePage
  },
  {
    path: '/login',
    name: 'login',
    component: LoginPage,
  },
  {
    path: '/join',
    name: 'join',
    component: JoinPage,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;
