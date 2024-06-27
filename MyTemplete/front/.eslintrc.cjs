/* eslint-env node */
require('@rushstack/eslint-patch/modern-module-resolution')

module.exports = {
  root: true,
  'extends': [
    'plugin:vue/vue3-essential',
    'eslint:recommended',
    '@vue/eslint-config-prettier/skip-formatting'
  ],
  parser: 'vue-eslint-parser',
  parserOptions: {
    parser: '@babel/eslint-parser',
    requireConfigFile: false,
    babelOptions: {
      presets: ['@babel/preset-env']
    },
    ecmaVersion: 'latest',
    sourceType: 'module'
  },
  env: {
    node: true,
    es6: true,
    browser: true
  },
  rules: {
    'no-undef': 'off'
  }
}
