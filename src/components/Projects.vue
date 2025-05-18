<template>
  <div class="project"> <!-- Site Web -->
<!--  a details :  mettre la même taille que celle de la liste des projets si on veut qu'un projet ai la même taille que les autres peu importe le contenu-->
    <div class="details">
      <div>
        <h3 class="title">{{ subtitle }}</h3>
        <div class="projectText" v-html="text"></div>
        <h4 class="outils-title">Outils utilisés</h4>
        <ul class="outils-list">
          <li v-for="(tool, toolIndex) in tools" :key="toolIndex">
            <div v-html="tool"></div>
          </li>
        </ul>
        <!-- Bouton conditionnel -->
        <a v-if="state === 'link'" :href="buttonLink" target="_blank">{{ buttonTitle }}</a>
        <a v-else-if="state === 'download'" :href="buttonLink" download>{{ buttonTitle }}</a>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AppProjects',
  props: {
    subtitle: {
      type: String,
      required: true
    },
    text: {
      type: String,
      required: true
    },
    tools: {
      type: Array,
      required: true
    },
    buttonLink: {
      type: String,
      required: true
    },
    buttonTitle: {
      type: String,
      required: true
    },
    state: {
      type: String,
      required: true
    }
  }
}
</script>