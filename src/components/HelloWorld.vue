<template>
  <div class="hello">
    <h1>{{ msg }} tes</h1>
  </div>

  <!--  <ul>-->
  <!--    <li v-for="oui in item" :key="oui.id">{{ oui.name }}</li>-->
  <!--  </ul>-->
  <!--  <ul>-->
  <!--    <li v-for="(id, index) in item" :key="index">{{ id }}</li>-->
  <!--  </ul>-->
</template>

<!--<script>-->
<!--export default {-->
<!--  name: 'AppHeader',-->
<!--  props: {-->
<!--    item: {-->
<!--      type: Array,-->
<!--      required: true // La prop est requise-->
<!--    }-->
<!--  }-->
<!--}-->
<!--</script>-->

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>

<!--Dans App.vue :-->
<!--<HelloWorld msg="Welcome to Your Vue.js App"/>-->

