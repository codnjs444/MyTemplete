<template>
  <v-app-bar app>
    <v-toolbar-title>
      <img :src="logo" alt="Logo" class="logo">
    </v-toolbar-title>
    <v-spacer></v-spacer>
    <v-btn text>추천 디자인 기능</v-btn>
    <v-btn text>비즈니스</v-btn>
    <v-btn text>교육용</v-btn>
    <v-btn text>요금제</v-btn>
    <v-btn text>사용 가이드</v-btn>
    <v-text-field
      solo
      hide-details
      prepend-inner-icon="mdi-magnify"
      label="추천 개의 템플릿 검색"
    ></v-text-field>
    <template v-if="isAuthenticated">
      <v-btn text @click="logout">로그아웃</v-btn>
    </template>
    <template v-else>
      <v-btn text @click="goToLogin">로그인</v-btn>
      <v-btn color="primary" @click="goToJoin">가입</v-btn>
    </template>
  </v-app-bar>
</template>

<script>
import { ref, computed } from 'vue';
import { useRouter } from 'vue-router';
import logo from '@/assets/logo.png'; // 이미지 파일을 가져옵니다.
import { useAuthStore } from '@/stores/authStore'; // Pinia 스토어를 가져옴

export default {
  name: 'BaseHeader',
  setup() {
    const logoSrc = ref(logo);
    const router = useRouter();
    const authStore = useAuthStore();

    const isAuthenticated = computed(() => authStore.isAuthenticated);

    const goToLogin = () => {
      router.push('/login');
    };

    const goToJoin = () => {
      router.push('/join');
    };

    const logout = () => {
      authStore.logout();
    };

    return {
      logo: logoSrc,
      isAuthenticated,
      goToLogin,
      goToJoin,
      logout
    };
  }
};
</script>

<style scoped>
.v-app-bar {
  background-color: white;
  color: black;
  border-bottom: 1px solid #ddd;
}

.v-btn {
  font-size: 14px;
  text-transform: none;
  margin-left: 10px;
}

.v-btn--primary {
  color: white !important;
}

.v-text-field {
  max-width: 300px;
  margin-left: 10px;
}

.logo {
  height: 40px;
}
</style>
