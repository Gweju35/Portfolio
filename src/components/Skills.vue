<template>
  <div class="p-6 sm:py-6 sm:px-10 lg:py-8 lg:px-16 rounded-2xl bg-pf-deep-blue1 flex flex-col items-center">
    <h3 class="text-xl md:text-2xl font-josefin font-medium text-center text-pf-green mb-6">{{ title }}</h3>
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