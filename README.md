### Link do Desafio
https://bossabox.notion.site/Back-end-0b2c45f1a00e4a849eefe3b1d57f23c6

### Implementado
- Autenticação com JWT
- Docker
- Bean Validation
- Exception Handler
- Pagination
### Futuramente Implementado
- Testes de Integração

### Rodando a Aplicação

```shell
# comando padrão para subir ambos os serviços: 
docker compose up -d

# se o banco não iniciar antes devido ao tempo de inicialização 
# do container, comprometendo o funcionamento da api, primero digite: 
docker compose up -d mysql

# em seguida quando o container mysql estiver pronto:
docker compose up -d api
```