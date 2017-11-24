<template>
  <div>
    <h1>Details</h1>
    <p></p>
    <dl>
      <dt>Id</dt><dd>{{ item.id }}</dd>
      <dt>Nom</dt><dd>{{ item.name }}</dd>
      <dt>Skill</dt><dd>{{ item.skill }}</dd>
    </dl>
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
//        item = {name: 'Bart', skill: 'Drink'}
//        $route.params.id

        AXIOS.get('api/heroes/' + this.$route.params.id)
          .then(response => {
            this.item = response.data
            console.log(response.data)
          })
          .catch(e => {
            this.errors.push(e)
          })
//
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
