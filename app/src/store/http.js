import axios from 'axios'
import qs from 'qs'

const created = axios.create({}),
request = function(route, type, body) {
  if (type === 'auth') {
    const data = {
      method: 'post',
      data: body,
      auth: {
        username: 'veneza',
        password: '123'
      }
    }

    console.log('will authenticate with data', data)
    return created.post('http://localhost:8080/oauth/token', data, {headers: {'Content-Type': 'multipart/form-data'}}).then((response) => {
      console.log('authenticated!', response)
    }, (e) => {
      console.log('failed to authenticate')
    })
  }
  return created[type](`http://localhost:8080/${route}`, body).then((response) => {
    return response.data;
  }, (e) => {
    // TODO check if is 401
    http.login();
  })
},
http = {
  login() {
    const username = window.prompt('Não Autenticado! Insira o usuário:'),
    password = window.prompt('Insira a senha:'),
    body = qs.stringify({
      grant_type: 'password',
      username,
      password
    })
    request('oauth/token', 'auth', body)
  },

  get(route) {
    return request(route, 'get')
  },

  post(route, body) {
    return request(route, 'post', body)
  }
}

export default http

