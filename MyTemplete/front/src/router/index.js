import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '@/components/HomePage.vue';
import LoginPage from '@/layout/login/LoginPage.vue';
import JoinPage from '@/layout/login/JoinPage.vue';
import TestPage1 from '@/components/TestPage1.vue';
import TestPage2 from '@/components/TestPage2.vue';
import TestPage3 from '@/components/TestPage3.vue';

const routes = [
  {
    path: '/',
    redirect: '/home'  // 기본 경로로 접속 시 /login으로 리디렉션
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
  {
    path: '/TestPage1',
    name: 'TestPage1',
    component: TestPage1
  },
  {
    path: '/TestPage2',
    name: 'TestPage2',
    component: TestPage2
  },
  {
    path: '/TestPage3',
    name: 'TestPage3',
    component: TestPage3
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;
