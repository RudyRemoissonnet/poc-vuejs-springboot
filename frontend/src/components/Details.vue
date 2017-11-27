<template>
  <div>
    <h1>{{ item.name }}</h1>
    <p></p>
    <dl>
      <dt>Id</dt><dd>{{ item.id }}</dd>
      <dt>Nom</dt><dd>{{ item.name }}</dd>
      <dt>Skill</dt><dd>{{ item.skill }}</dd>
    </dl>
    <b-button variant="primary" @click="goBack()">Retour</b-button>
  </div>
</template>

<script>
  import {AXIOS} from './http-common'

  var item = {}

  export default {
    name: 'Details',

    data () {
      return {
        item: item,
        errors: []
      }
    },
    methods: {
      callRestHeroesDetail () {
        AXIOS.get('api/heroes/' + this.$route.params.id)
          .then(response => {
            this.item = response.data
            console.log(response.data)
          })
          .catch(e => {
            this.errors.push(e)
          })
      },
      goBack () {
        this.$router.go(-1)
      }
    },
    created () {
      console.log('created')
      this.callRestHeroesDetail()
    }
  }
</script>

<style scoped>
  h1, h2 {
    font-weight: normal;
  }
</style>
