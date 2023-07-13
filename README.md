Tema 2:​ Sistema de vendas

A equipe deve montar um sistema de vendas de produtos. Onde cada produto deve ter, no mínimo, preço e descrição e cada venda uma lista de produtos, um vendedor, data e hora e valor total da venda. O sistema deve ser capaz de fazer buscas de vendas por vendedor e por data. O sistema deve prover acesso de login e senha, diferenciando o gerente, vendedor e cliente. OBS: ​Pode ser estendido para situações semelhantes como, biblioteca, aluguel de carro, etc



Subpastas do repositório

>Idea
    Essa pasta contém arquivos de configuração 

>API/src
    A lógica principal do Backend está contida na pasta "src"

>Main
    >Java
        >Configuration
            Os arquivos usam ferramentas do Spring pra realizar autenticação do usuário, e JWT

        >Controller
            Nessa pasta são criados os  controladores da aplicação. Em cada um deles, é feita uma anotação do tipo @Controlller e outra do tipo @RequestMapping que faz um mapeamento para a URL que o controlador será chamado.

        >Model
            >DTO
                >Pojos
                    Esse DTO é usado para retornar informações básicas de um usuário em uma resposta de API, onde os detalhes sensíveis, como a senha, não são expostos.  
                >Request
                    Os DTOs nessa subpasta são DTOs de entrada ou de solicitação. São definidas classes responsáveis por encapsular os dados enviados em uma requisição para um detrminado serviço ou endpoint de uma API.
                >Response
                    Os DTOs nessa subpasta são DTOs de saída ou de resposta. Eles representam a estrutura dos dados que serão enviados de volta ao cliente após a execução de uma operação.
            >Entity
                Aqui estão as classes que representam as entidades principais para o funcionamento lógico da aplicação.
            >Enums
                Aqui são arquivos que criam um mapeamento entre duas ou mais informações, de modo a se criar uma relação lógica entre elas.

        >Repository
            Aqui estão classes responsáveis por lidar com a persistência e recuperação de dados do banco de dados. As classes extendem a interface 'JpaRepository' do Spring Data JPA

        >Security
            Aqui estão contidas as configurações básicas de segurança da aplicação, incluindo a definição de provedor de autenticação, criptografia de senhas, permissões de acesso e configurações de autenticação.

        >Service
            Os arquivos nessa subpasta são responsáveis por encapsular a lógica de negócios e  coordenar os diferentes componentes da aplicação
            
    >Resources
        Configurações acerca do Banco de dados Postgres