import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '@/components/HomePage.vue';

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomePage
  },
  // 다른 라우터 설정이 있다면 여기에 추가
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;
