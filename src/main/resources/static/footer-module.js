import Vue from 'vue/types';
import VueResource from 'vue-resource';
import appFooter from './footer.vue'
import VueMaterial from 'vue-material'
import 'vue-material/dist/vue-material.min.css'
import 'vue-material/dist/theme/black-green-light.css'

Vue.use(VueMaterial);
Vue.use(VueResource);

Vue.component("app-footer", appFooter);

new Vue({});