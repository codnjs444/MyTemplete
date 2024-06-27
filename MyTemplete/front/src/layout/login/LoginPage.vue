<template>
    <v-app>
      <v-container class="login-container">
        <v-row justify="center">
          <v-col cols="12" sm="8" md="4">
            <v-card class="login-card">
              <v-card-title class="headline">로그인</v-card-title>
              <v-card-subtitle class="subtitle">Hey enter your details to log in to your account</v-card-subtitle>
              <v-card-text>
                <v-form @submit.prevent="login">
                  <v-text-field
                    v-model="userId"
                    label="아이디를 입력해주세요."
                    required
                    prepend-inner-icon="mdi-account"
                    class="mb-4"
                  ></v-text-field>
                  <v-text-field
                    v-model="userPassword"
                    label="비밀번호를 입력해주세요."
                    type="password"
                    required
                    prepend-inner-icon="mdi-lock"
                    class="mb-4"
                  ></v-text-field>
                  <v-btn type="submit" color="primary" class="login-btn">로그인</v-btn>
                </v-form>
              </v-card-text>
              <v-card-actions class="justify-center">
                <v-btn text class="signup-link">계정이 없으신가요? 회원 가입</v-btn>
              </v-card-actions>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-app>
  </template>
  
  <script>
  import axios from 'axios';
  import { useRouter } from 'vue-router';
  
  export default {
    name: 'LoginPage',
    data() {
      return {
        userId: '',
        userPassword: '',
      };
    },
    setup() {
      const router = useRouter();
      return { router };
    },
    methods: {
      async login() {
        try {
          const response = await axios.post('/user/login', {
            userId: this.userId,
            userPassword: this.userPassword,
          });
          console.log(response.data);
          alert('Login successful');
          this.router.push('/');
        } catch (error) {
          console.error('Login failed', error);
          alert('Login failed');
        }
      },
    },
  };
  </script>
  
  <style scoped>
  .login-container {
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: #f5f6fa;
  }
  
  .login-card {
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0px 10px 30px rgba(0, 0, 0, 0.1);
    text-align: center;
  }
  
  .headline {
    font-size: 24px;
    font-weight: bold;
  }
  
  .subtitle {
    font-size: 14px;
    color: #888;
    margin-bottom: 20px;
  }
  
  .mb-4 {
    margin-bottom: 20px;
  }
  
  .login-btn {
    width: 100%;
    background-color: #3f51b5;
    color: #fff;
    font-weight: bold;
    border-radius: 5px;
  }
  
  .signup-link {
    font-size: 14px;
    color: #3f51b5;
    cursor: pointer;
    text-transform: none;
  }
  </style>
  