<template>
 <b-container fluid>
    <b-col cols="12" sm="12" md="12" lg="12">&nbsp;</b-col>

    <b-row>
      <b-col cols="12" sm="12" md="12" lg="6">
        <label>Nome</label>
        <b-form-input id="cliente-nome" :disabled="disabled" v-model="model.nome" required />
      </b-col>
      
      <b-col cols="12" sm="12" md="6" lg="3">
        <label>CPF</label>
        <the-mask id="cliente-cpf" :disabled=disabled pattern="\d*" v-model="model.cpf" :mask="'###.###.###-##'" placeholder="000.000.000-00" class="form-control" required />
      </b-col>

      <b-col cols="12" sm="12" md="6" lg="3">
        <label>Telefone</label>
        <the-mask id="cliente-telefone" :disabled="disabled" pattern="\d*" v-model="model.telefone" :mask="['(##) ####-####', '(##) #####-####']" placeholder="(00) 00000-0000" class="form-control" required />
      </b-col>

      <b-col cols="12" sm="12" md="12" lg="12">&nbsp;</b-col>

      <b-col cols="12" class="text-right" v-if="disabled">
        <b-button id="cliente-edit" @click="edit" type="submit" size="sm" squared variant="success" title="Editar">
          <font-awesome-icon icon="save"/>&nbsp;Editar
        </b-button>
      </b-col>
      <b-col cols="12" class="text-right" v-else>
        <b-button id="cliente-save" @click="save" type="submit" size="sm" squared variant="success" title="Salvar">
          <font-awesome-icon icon="save"/>&nbsp;Salvar
        </b-button>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
  import * as App from '@/App'
  import http from '@/store/http'

  export default {
    name: 'input-cliente',

    data () {
      return {
        model: {},
        disabled: false,
        App: App
      }
    },

    methods: {
      save() {
        if (!this.model.nome || !this.model.cpf || !this.model.telefone) {
          alert('Deve preencher todos os campos!');
        } else {
          http.post('clientes', this.model).then((response) => {
            this.model = response;
            this.$router.push({name: 'clientes-show', params: {_id: this.model._id}}).catch(e => e).then(() => {
              this.$router.go();
            });
          });
        }
      },

      show(_id) {
        http.get(`/clientes/${_id}`).then(response => {
          this.model = response;
        });
      },

      edit() {
        this.$router.push({name: 'clientes-edit', params: {_id: this.$route.params._id}});
        this.disabled = false;
      }
    },

    mounted() {
      let _id = this.$route.params._id;
      if (_id) {
        this.show(_id)
      }
      
      this.disabled = this.$route.path.includes('/show');
    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
  h1, h2 {
    font-weight: normal;
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
    color: #35495E;
  }
</style>
