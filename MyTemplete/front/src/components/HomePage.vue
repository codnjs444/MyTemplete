<template>
  <v-app>
    <v-container>
      <v-row>
        <v-col cols="12" md="8" offset-md="2">
          <v-card>
            <v-card-title class="headline">User Information</v-card-title>
            <v-card-text v-if="user">
              User ID: {{ user.userId }} <br />
              User Name: {{ user.userName }}
            </v-card-text>
            <v-card-text v-else>
              Loading...
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-app>
</template>

<script>
import { ref, onMounted } from 'vue';
import axios from 'axios';

export default {
  name: 'HomePage',
  setup() {
    const user = ref(null);

    onMounted(() => {
      axios.get('/user', { params: { userId: 'aaa' } })
        .then(response => {
          user.value = response.data;
        })
        .catch(error => {
          console.error(error);
        });
    });

    return {
      user,
    };
  },
};
</script>

<style scoped>
/* 필요한 스타일을 추가할 수 있습니다. */
</style>
