<template>
  <div>
    <b-container>
      <b-col class="page-title-holder d-flex align-items-center">
        <h3 class="page-title">Clientes</h3>
        <div class="page-title-controls">
          <b-button id="cliente-new" @click="_new" variant="success" size="sm" squared title="Novo cliente">
            <font-awesome-icon icon="plus"/> Novo
          </b-button>
        </div>
      </b-col>
    </b-container>

    <div>&nbsp;</div>
    
    <b-container>
      <b-col>
        <b-table
          head-variant="light"
          light small striped hover
          :fields="fields"
          :items="model"
          @row-clicked="rowClicked"
          v-bind:style="{cursor: 'pointer'}">
          <template v-slot:cell(identificacao.cpf)="data">
            {{App.formatCpf(data.item.identificacao ? data.item.identificacao.cpf : '')}}
          </template>
        </b-table>
      </b-col>
      <div>&nbsp;</div>
    </b-container>
  </div>
</template>

<script>
  import * as App from '@/App'
  import http from '@/store/http'

  export default {
    name: 'clientes',

    data() {
      return {
        fields: [
          {
            key: 'cpf',
            label: 'CPF',
            sortable: false
          },
          {
            key: 'nome',
            label: 'Nome'
          }
        ],
        model: [],
        App: App
      }
    },

    computed: {
      rows() {
        return this.model.length
      }      
    },

    methods: {
      index(){
        http.get('clientes').then((data) => {
          this.model = data;
        });
      },
      show(_id) {
        this.$router.push({name: `clientes-show`, params: { _id }})
      },
      _new(){
        this.$router.push({name: `clientes-new`})
      },
      rowClicked(data) {
        this.$router.push(`cliente/${data._id}/show`);
      }
    },

    mounted() {
      this.index();
    },

    components: {}
  };
</script>

<style scoped>
  svg[data-icon='edit'].index-icon {
    color: grey;
  }

  svg[data-icon='sync'].index-icon {
    color: #337ab7;
  }

  svg[data-icon='minus-circle'].index-icon {
    color: red;
  }

  svg[data-icon='check'].index-icon {
    color: green;
  }

  .col-padding {
    padding-left: 1em !important;
    padding-right: 1em !important;
  }
</style>