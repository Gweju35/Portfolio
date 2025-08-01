import { createApp } from 'vue'
import App from './App.vue'
import './assets/style.css';

import {initAccordionSkills} from '@/assets/js/initAccordionSkills.js';
import {initBackToTop} from "@/assets/js/common/initBackToTop";

createApp(App).mount('#app')


// Fonction qui permet d'initialiser l'application
function initApp() {


    initBackToTop();


    initComponents();
}


// Fonction qui permet d'initialiser les composants spécifiques
function initComponents() {
    initAccordionSkills();
}


initApp();