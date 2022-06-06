# Api-teste

api Criada para testar proeficiencia em Java Spring boot, utilizando spring boot, mongoDB e mysql, api devidamente configurada para rodar em conteiner utilizando o docker.

funcionalidades
• Cadastro de usuário
• Login de usuário
• Listar moedas (incluir se a moeda é um favorito)
• Listar favoritos (trazer informações das moedas)
• Favoritar moeda
• Modificar anotação
• Remover favorito
###
Castro de usuarios
metodo Post "/user/cadastro" 
body{
String name, String password}
Retorno 200-ok, retornará uma exception para caso já existe um usuario cadastrado com esse name;
####
Login de usuário
metodo Post "/user/login" 
body{
String name, String password}
Retorno int com Id do usuario logado, retornará uma exception para caso não consiga validar name e password;
###
Listar moedas
GET "/coin/{user_id}"
retorno{ String id;
         String name;
         String symbol;
         String type;
         Booleam is_favorite}
###
Listar favoritos
GET "coin/favorites/{user_id}"
retorno{ String id;
         String name;
         String symbol;
         String type;}
###
Favoritar moeda
POST "/coin/favoritar"
BODY {int user_id;
      String coin_id;
      String notes;}
retorno 200-ok
####
Modificar anotação
POST /coin/atualizar
BODY {int user_id;
      String coin_id;
      String notes;}    
retonor 200-ok
  
###
Remover favorito
Post "/delete"
BODY {int user_id;
      String coin_id;}
retorno 200-ok



