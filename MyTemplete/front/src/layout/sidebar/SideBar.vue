<template>
    <v-navigation-drawer app>
      <v-list dense>
        <v-list-item-group>
          <v-list-item @click="navigateTo('TestPage1')">
            <v-list-item-content>
              <v-list-item-title>Test1</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item @click="navigateTo('TestPage2')">
            <v-list-item-content>
              <v-list-item-title>Test2</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item @click="navigateTo('TestPage3')">
            <v-list-item-content>
              <v-list-item-title>Test3</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>
  </template>
  
  <script>
  import { useRouter } from 'vue-router';
  
  export default {
    name: 'SideBar',
    setup() {
      const router = useRouter();
  
      function navigateTo(route) {
        router.push({ name: route });
      }
  
      return {
        navigateTo
      };
    }
  }
  </script>
  
  <style scoped>
  </style>
  