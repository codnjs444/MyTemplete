const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,

  pluginOptions: {
    vuetify: {
      // https://github.com/vuetifyjs/vuetify-loader/tree/next/packages/vuetify-loader
    }
  },

  devServer: {
    port: 8081, // Vue.js 개발 서버 포트를 8081로 설정
    proxy: {
      '/': {
        target: 'http://localhost:8080', // 백엔드 서버의 주소
        changeOrigin: true,
        ws: false, // WebSocket 지원 추가
        pathRewrite: { '^/': '' },
      },
    },
  },

  chainWebpack: config => {
    config.plugins.delete('prefetch'); // prefetch 기능 비활성화
  },

})
