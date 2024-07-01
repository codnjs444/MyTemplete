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
      <v-btn text @click="goToLogin">로그인</v-btn>
      <v-btn color="primary" @click="goToJoin">가입</v-btn>
    </v-app-bar>
  </template>
  
  <script>
  import { ref } from 'vue';
  import { useRouter } from 'vue-router';
  import logo from '@/assets/logo.png'; // 이미지 파일을 가져옵니다.
  
  export default {
    name: 'BaseHeader',
    setup() {
      const logoSrc = ref(logo);
      const router = useRouter();
  
      const goToLogin = () => {
      router.push('/login');
      };

      const goToJoin = () => {
      router.push('/join');
      };

      return {
        logo: logoSrc,
        goToLogin,
        goToJoin
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
  