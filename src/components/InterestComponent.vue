<template>
  <div class="relative w-full px-4 sm:max-w-[50%] sm:grow-0 sm:shrink-0 sm:basis-1/2 xl:max-w-[25%] xl:basis-1/4">
    <div class="rounded-lg mb-7">
      <div :class="`bg-[${color}] relative overflow-hidden py-10 px-8 rounded-lg`">
        <div class="text-[160px] absolute leading-none -right-8 -bottom-8 opacity-30">
          <img :src="`${iconUrl}`" class="size-40" alt="Icône d'intérêts">
        </div>
        <div class="leading-none text-5xl mb-6">
          <img :src="`${iconUrl}`" class="size-14" alt="Icône d'intérêts">
        </div>
        <h5 class="text-xl sm:text-2xl font-bold font-josefin m-0 -mt-0.5">{{ title }}</h5>
      </div>
    </div>
  </div>
</template>

<script>
import FootballIcon from '@/assets/images/icons/football.svg';
import BooksIcon from '@/assets/images/icons/books.svg';
import MoviesIcon from '@/assets/images/icons/movies.svg';
import VideogamesIcon from '@/assets/images/icons/videogames.svg';
export default {
  name: 'InterestComponent',
  props: {
    color: {
      type: String,
      required: true
    },
    title: {
      type: String,
      required: true
    },
    img: {
      type: String,
      required: true
    }
  },
  computed: {
    // Vérifie la valeur de `name` pour déterminer quelle icône utiliser
    iconUrl() {
      switch (this.img.toLowerCase()) {
        case 'football':
          return FootballIcon;
        case 'books':
          return BooksIcon;
        case 'movies':
          return MoviesIcon;
        case 'videogames':
          return VideogamesIcon;
        default:
          return null;
      }
    },
  }
}
</script>
