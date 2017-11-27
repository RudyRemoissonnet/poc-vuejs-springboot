<template>
  <div class="hello">
    <h1>{{ subTitle }}</h1>
    <p></p>
    <b-button variant="primary" @click="callRestHeroes()">get heroes list</b-button>
    <p></p>
    <b-table striped hover :items="items" :fields="fields">
      <template slot="actions" slot-scope="row">
        <!-- We use click.stop here to prevent a 'row-clicked' event from also happening -->
        <b-btn size="sm" @click.stop="details(row.item, row.index, $event.target)">Details</b-btn>
      </template>
    </b-table>

    <!-- Details modal -->
    <b-modal id="modal1" @hide="resetModal" ok-only>
      <h4 class="my-1 py-1" slot="modal-header">Index: {{ modalDetails.index }}</h4>
      <pre>{{ modalDetails.data }}</pre>
    </b-modal>

  </div>
</template>

<script>
  // import axios from 'axios'
  import {AXIOS} from './http-common'

  var items

  export default {
    name: 'Heroes',

    data () {
      return {
        subTitle: 'Heroes',
        fields: {
          name: {label: 'Nom', sortable: true},
          skill: {label: 'Pouvoir'},
          actions: {label: 'Actions'}
        },
        modalDetails: {index: '', data: ''},
        items: items,
        errors: []
      }
    },
    methods: {
      callRestHeroes () {
        AXIOS.get('api/heroes')
          .then(response => {
            this.items = response.data
            console.log(response.data)
          })
          .catch(e => {
            this.errors.push(e)
            alert(e)
          })
      },
      details (item, index, button) {
//        this.modalDetails.data = JSON.stringify(item, null, 2)
//        this.modalDetails.index = index
//        this.$root.$emit('bv::show::modal', 'modal1', button)
        this.$router.push({name: 'Details', params: {id: item.id}})
      },
      resetModal () {
        this.modalDetails.data = ''
        this.modalDetails.index = ''
      }
    }
  }
</script>

<style scoped>
  h1, h2 {
    font-weight: normal;
  }
</style>
