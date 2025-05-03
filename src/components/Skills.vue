<template>

  <div class="js-skills-accordion bg-pf-deep-blue1 p-4 sm:px-8 sm:py-5 flex flex-col">
    <div class="js-toggle-skills flex flex-row justify-between cursor-pointer">
      <h3 class="text-xl md:text-2xl font-josefin font-medium text-pf-green">{{ title }}</h3>
      <svg class="js-plus-skills transition-transform duration-300" width="25" height="25" viewBox="0 0 25 25" fill="none" xmlns="http://www.w3.org/2000/svg">
        <circle cx="12.5" cy="12.5" r="12" stroke="#08d565"/>
        <rect x="6.6665" y="11.6665" width="11.6667" height="1.66667" fill="#08d565"/>
        <rect x="13.3335" y="6.6665" width="11.6667" height="1.66667" transform="rotate(90 13.3335 6.6665)" fill="#08d565"/>
      </svg>
    </div>
    <div class="js-content-skills overflow-hidden hidden">
      <div class="flex flex-col gap-y-6">
        <div class="flex flex-row justify-between">
          <p></p>
        </div>
        <div class="flex flex-wrap justify-center gap-6 sm:gap-x-10">
          <div v-for="(skill, index) in skills" :key="index" class="flex flex-col min-w-24">
            <div class="flex flex-col items-center">
              <p class="skillIcon text-3xl sm:text-4xl lg:text-5xl text-pf-green" v-html="skill.icon"></p>
              <p class="text-lg sm:text-xl font-semibold">{{ skill.name }}</p>
              <!--          <span class="text-sm sm:text-base text-gray-100 text-opacity-75">{{ skill.level }}%</span>-->
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

</template>

<script>
export default {
  name: 'AppSkills',
  props: {
    title: {
      type: String,
      required: true, // Titre de la catégorie (ex. "Développement Web")
    },
    skills: {
      type: Array,
      required: true, // Liste des compétences (tableau d'objets)
    },
  },
}
</script>