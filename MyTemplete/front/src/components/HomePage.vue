<template>
  <v-app>
    <BaseHeader />
    <SideBar />
    <v-main>
      <v-container>
        <v-row justify="center">
          <v-col cols="12">
            <v-card>
              <v-card-title class="headline">홈 페이지</v-card-title>
              <v-card-text>
                로그인에 성공하셨습니다! 여기는 홈 페이지입니다.!
              </v-card-text>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import BaseHeader from '@/layout/header/BaseHeader.vue';
import SideBar from '@/layout/sidebar/SideBar.vue';

export default {
  name: 'HomePage',
  components: {
    BaseHeader,
    SideBar,
  },
};
</script>

<style scoped>
</style>
