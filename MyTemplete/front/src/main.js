import { createApp } from 'vue';
import App from './App.vue';
import vuetify from './plugins/vuetify';
import { loadFonts } from './plugins/webfontloader';
import router from './router';
import './utils/axios' // axios 설정 파일을 불러옴

loadFonts();

const app = createApp(App);

app.use(router);
app.use(vuetify);
app.mount('#app');
