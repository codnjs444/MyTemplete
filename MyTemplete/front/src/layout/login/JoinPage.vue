<template>
  <v-app>
    <v-container class="login-container">
      <v-row justify="center">
        <v-col cols="12" sm="8" md="4">
          <v-card class="login-card">
            <v-card-title class="headline">회원 가입</v-card-title>
            <v-card-subtitle class="subtitle">Please fill in the details to create an account</v-card-subtitle>
            <v-card-text>
              <v-form @submit.prevent="join">
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
                <v-text-field
                  v-model="userName"
                  label="이름을 입력해주세요."
                  required
                  prepend-inner-icon="mdi-account"
                  class="mb-4"
                ></v-text-field>
                <v-text-field
                  v-model="userEmail"
                  label="이메일을 입력해주세요."
                  required
                  prepend-inner-icon="mdi-email"
                  class="mb-4"
                ></v-text-field>
                <v-btn type="submit" color="primary" class="login-btn">회원 가입</v-btn>
              </v-form>
            </v-card-text>
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
  name: 'JoinPage',
  data() {
    return {
      userId: '',
      userPassword: '',
      userName: '',
      userEmail: '',
    };
  },
  setup() {
    const router = useRouter();
    return { router };
  },
  methods: {
    async join() {
      try {
        const response = await axios.post('/user/join', {
          userId: this.userId,
          userPassword: this.userPassword,
          userName: this.userName,
          userEmail: this.userEmail,
        });
        console.log(response.data);
        alert('회원 가입이 성공적으로 완료되었습니다.');
        this.router.push('/login');
      } catch (error) {
        console.error('회원 가입 실패', error);
        if (error.response && error.response.status === 409) {
          alert('이미 존재하는 아이디입니다.');
        } else {
          alert('회원 가입에 실패하였습니다.');
        }
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
</style>
