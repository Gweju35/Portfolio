import { createApp } from 'vue'
import App from './App.vue'
import './assets/style.css';

import { initAccordionSkills } from './assets/js/initAccordionSkills.js';

createApp(App).mount('#app')

initAccordionSkills();