import { defineStore } from 'pinia';
import axios from 'axios';

// useAuthStore라는 이름의 store 생성 (사용자의 로그인 여부 관리)
export const useAuthStore = defineStore(
  'auth', {
  state: () => ({
    isAuthenticated: false,
    token: null,
  }),
  actions: {
    async login(userId, userPassword) {
      try {
        const response = await axios.post('/user/login', { userId, userPassword });
        this.isAuthenticated = true;
        this.token = response.data;
        localStorage.setItem('token', this.token);
      } catch (error) {
        console.error('Login failed', error);
        alert('Login failed');
      }
    },
    logout() {
      this.isAuthenticated = false;
      this.token = null;
      localStorage.removeItem('token');
    },
  },
});
