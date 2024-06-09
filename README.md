### Link do Desafio
https://bossabox.notion.site/Back-end-0b2c45f1a00e4a849eefe3b1d57f23c6

### Tecnologias  
<div >
	<img width="50" style="margin-right:5px;" src="https://user-images.githubusercontent.com/25181517/117201156-9a724800-adec-11eb-9a9d-3cd0f67da4bc.png" alt="Java" title="Java"/>
	<img width="50" style="margin-right:5px;"  src="https://user-images.githubusercontent.com/25181517/183891303-41f257f8-6b3d-487c-aa56-c497b880d0fb.png" alt="Spring Boot" title="Spring Boot"/>
	<img width="50" style="margin-right:5px;"  src="https://user-images.githubusercontent.com/25181517/117207493-49665200-adf4-11eb-808e-a9c0fcc2a0a0.png" alt="Hibernate" title="Hibernate"/>
	<img width="50" style="margin-right:5px;"  src="https://user-images.githubusercontent.com/25181517/183896128-ec99105a-ec1a-4d85-b08b-1aa1620b2046.png" alt="MySQL" title="MySQL"/>
	<img width="50" style="margin-right:5px;"  src="https://user-images.githubusercontent.com/25181517/117207330-263ba280-adf4-11eb-9b97-0ac5b40bc3be.png" alt="Docker" title="Docker"/>
</div>

### Implementado
- Autenticação com JWT
- Conteinerização da API e Database
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