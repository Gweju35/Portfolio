<template>
  <div class="relative w-full px-4 lg:grow-0 lg:shrink-0 lg:basis-1/2 flex">
    <div class="degreeBackground p-10 border border-white border-opacity-20 mt-0 mx-auto mb-7 flex-1">
      <h5 class="mb-4 text-xl md:text-2xl font-bold m-0 text-white font-josefin">{{ year }} — {{ title }}</h5>
      <div class="degreeDescription" v-html="text"></div> <!-- Permet d'interpréter le html présent dans le json -->
    </div>
  </div>
</template>

<script>
export default {
  name: 'AppDegrees',
  props: {
    year: {
      type: String,
      required: true
    },
    title: {
      type: String,
      required: true
    },
    text: {
      type: String,
      required: true
    }
  }
}
</script>