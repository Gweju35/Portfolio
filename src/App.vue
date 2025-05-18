<template>
  <!-- Preloader -->
  <div class="preloader" style="opacity: 1;">
    <span class="loader"><span></span></span>
    <p class="loading">Loading ...</p>
  </div>

  <!-- Back to Top -->
  <button class="backToTop" @click="scrollToTop" :class="{ active: isButtonActive }">
    <svg class="svgIcon" viewBox="0 0 384 512"><path d="M214.6 41.4c-12.5-12.5-32.8-12.5-45.3 0l-160 160c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0L160 141.2V448c0 17.7 14.3 32 32 32s32-14.3 32-32V141.2L329.4 246.6c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3l-160-160z"></path></svg>
  </button>

  <!-- Header -->
  <AppHeader/>

  <!-- Hero-Header -->
  <PageHeader/>

  <!-- Diplômes -->
  <section class="pt-16 sm:pt-24" id="diplomes">
    <div class="w-full container">
      <TitleComponent title="Diplômes"/>
      <div class="-mb-8 flex flex-wrap justify-center -mx-4 items-stretch">
        <AppDegrees v-for="degree in degrees" :key="degree.id" :year="degree.year" :title="degree.title" :text="degree.text"/>
      </div>
    </div>
  </section>

  <!-- Expériences -->
  <section class="pt-16 sm:pt-24" id="experiences">
    <div class="w-full container">
      <TitleComponent title="Expériences"/>
      <div class="-mb-8">
        <AppExperiences v-for="experience in experiences" :key="experience.id" :title="experience.title" :text="experience.text" :img="experience.img"/>
      </div>
    </div>
  </section>

  <!-- Projets -->
  <section class="pt-16 sm:pt-24" id="projets">
    <div class="w-full container">
      <TitleComponent title="Projets"/>
      <div class="flex flex-wrap justify-between">
        <!-- Liste des projets -->
        <div class="projectMenu w-full md:w-44 md:overflow-x-hidden md:h-[590px] xl:h-[510px]">
          <ul class="projectList gap-1.5 sm:gap-4 p-0 text-lg border-none flex flex-wrap list-none justify-center">
            <li v-for="(project, index) in projects" :key="project.id" @click="setActiveProject(index)" :class="['cursor-pointer list-none', { 'ActiveProject': index === activeProjectIndex }]">
              <span class="py-4 px-1 min-w-32 sm:min-w-40 text-sm sm:text-base text-center  border-2 border-[#272440] bg-pf-deep-blue1 font-josefin block transition-colors duration-300 ease-in-out hover:text-pf-green">
                {{ project.title }}
              </span>
            </li>
          </ul>
        </div>
        <!-- Projet -->
        <div class="w-full md:w-[calc(100%-215px)]">
          <AppProjects v-for="(project, index) in projects" :key="project.id" v-show="index === activeProjectIndex"
          :skills="project.skills" :subtitle="project.subtitle" :text="project.text" :tools="project.tools" :buttonLink="project.buttonLink"
          :buttonTitle="project.buttonTitle" :state="project.state"/>
        </div>
      </div>
    </div>
  </section>

  <!-- Compétences -->
  <section class="pt-16 sm:pt-24" id="competences">
    <div class="w-full container">
      <TitleComponent title="Compétences"/>
      <div class="grid gap-y-8">
        <AppSkills v-for="(category, index) in skills" :key="index" :title="category.title" :skills="category.list"/>
      </div>
    </div>
  </section>

  <!-- Intérêts -->
  <section class="pt-16 sm:pt-24">
    <div class="w-full container">
  <!--      <TitleComponent title="Intérêts"/>-->
      <div class="flex flex-wrap justify-center">
        <InterestComponent v-for="interest in interests" :key="interest.id" :color="interest.color" :title="interest.title" :img="interest.img"/>
      </div>
    </div>
  </section>

  <!-- Contacts -->
  <AppContact/>

</template>

<script>
import AppHeader from "@/components/Header.vue";
import PageHeader from "@/components/PageHeader.vue";
import AppDegrees from "@/components/Degrees.vue";
import AppExperiences from "@/components/Experiences.vue";
import AppProjects from "@/components/Projects.vue";
import AppSkills from "@/components/Skills.vue";
import AppContact from "@/components/Contact.vue";

import InterestComponent from "@/components/InterestComponent.vue";
import TitleComponent from "@/components/TitleComponent.vue";

import jsonDataInterests from "@/database/interests.json";
import jsonDataDegrees from "@/database/degrees.json";
import jsonDataExperiences from "@/database/experiences.json";
import jsonDataProjects from "@/database/projects.json";
import jsonDataSkills from "@/database/skills.json";

export default {
  name: 'App',
  components: {
    AppHeader,
    PageHeader,
    AppDegrees,
    AppExperiences,
    AppProjects,
    AppSkills,
    AppContact,
    InterestComponent,
    TitleComponent
  },
  data() {
    return {
      interests: jsonDataInterests.interests,
      degrees: jsonDataDegrees.degrees,
      experiences: jsonDataExperiences.experiences,
      // item: jsonData.items // Récupère tout l'item
      // item: jsonData.items.map(item => item.id) // Récupère juste l'id de l'item
      activeProjectIndex: 0, // Index du projet actif
      projects: jsonDataProjects.projects,
      skills: jsonDataSkills.skills,
      isButtonActive: false,
    };
  },
  methods: {
    setActiveProject(index) {
      this.activeProjectIndex = index;
    },
    scrollToTop() {
      window.scrollTo({
        top: 0, // Remonte en haut de la page
      });
    },
    handleScroll() {
      const scrollPosition = window.scrollY;
      this.isButtonActive = scrollPosition > 100; // Active le bouton si on a scrollé de 100px ou plus
    },
  },
  mounted() {
    window.addEventListener("scroll", this.handleScroll); // Ajoute un écouteur de scroll
    // Initialisation des éléments
    const preloader = document.querySelector(".preloader");
    const loader = document.querySelector(".loader");
    const loading = document.querySelector(".loading");

    // Gestion des transitions
    setTimeout(() => {
      loader.style.transition = "opacity 1s";
      loading.style.transition = "opacity 1s";
      loader.style.opacity = "0";
      loading.style.opacity = "0";
    }, 500);

    setTimeout(() => {
      preloader.style.transition = "opacity 1.5s";
      preloader.style.opacity = "0";
    }, 1000);

    setTimeout(() => {
      preloader.style.display = "none";
    }, 2500);

    // Attribution d'une classe aléatoire au loader
    const loaderClasses = ["loader-quart", "loader-double", "loader-circles", "loader-bars"];
    const randomIndex = Math.floor(Math.random() * loaderClasses.length);
    loader.classList.add(loaderClasses[randomIndex]);
  },
  beforeUnmount() {
    window.removeEventListener("scroll", this.handleScroll); // Supprime l'écouteur de scroll
  },
};

</script>

<!--<style>-->
<!--#app {-->
<!--  font-family: Avenir, Helvetica, Arial, sans-serif;-->
<!--  -webkit-font-smoothing: antialiased;-->
<!--  -moz-osx-font-smoothing: grayscale;-->
<!--  text-align: center;-->
<!--  color: #2c3e50;-->
<!--}-->
<!--</style>-->
