#include <iostream>
#include <string>

using namespace std;

const int limiteEstoque = 50;
const int limiteFuncionarios = 20;

class Funcionario{
    private:
        int idFuncionario;
        string nomeFuncionario;

    public:
        int getIdFuncionario()
        {
            return idFuncionario;
        }
    
        void setIdFuncionario(int id)
        {
            idFuncionario = id;
        }
    
        string getNomeFuncionario()
        {
            return nomeFuncionario;
        };
        
        void setNomeFuncionario(string nome)
        {
            nomeFuncionario = nome;
        };
};


class Produto{
    private:
        int idProduto;
        string nomeProduto;
        int quantidadeProduto;

    public:
        int getIdProduto()
        {
            return idProduto;
        }
    
        void setIdProduto(int id)
        {
            idProduto = id;
        }
    
        string getNomeProduto()
        {
            return nomeProduto;
        };
        
        void setNomeProduto(string nome)
        {
            nomeProduto = nome;
        };
        
        int getQuantidadeProduto()
        {
            return quantidadeProduto;
        }
    
        void setQuantidadeProduto(int quantidade)
        {
            quantidadeProduto = quantidade;
        }
};


class Estoque{
    private:
        int idAlteracao;
        int idAlteracaoFuncionario;
        int numeroAlteracao;
        int produtoNum = 0;
        int funcionarioNum = 0;
        Produto listaProduto[limiteEstoque];
        Funcionario listaFuncionario[limiteFuncionarios];

    public:
        void cadastrarProduto()
        {
            Produto produto;
            string nomeProduto;
            int quantidadeProduto;
            
            cout<<"\nDigite o nome do Produto: ";
            cin.ignore();
            getline(cin, nomeProduto);
            
            produto.setNomeProduto(nomeProduto);
            
            cout<<"Digite a quantidade do Produto: ";
            cin>>quantidadeProduto;
            
            produto.setQuantidadeProduto(quantidadeProduto);
            
            produto.setIdProduto(produtoNum);
            listaProduto[produtoNum] = produto;
            produtoNum++;
            
            cout<<"Produto cadastrado com sucesso! \n";
        };
        
        void cadastrarFuncionario()
        {
            Funcionario funcionario;
            string nomeFuncionario;
            
            cout<<"\nDigite o nome do funcionário: ";
            cin.ignore();
            getline(cin, nomeFuncionario);
            
            funcionario.setNomeFuncionario(nomeFuncionario);
            
            funcionario.setIdFuncionario(funcionarioNum);
            listaFuncionario[funcionarioNum] = funcionario;
            funcionarioNum++;
            
            cout<<"Funcionário cadastrado com sucesso! \n";
        };
    
        void listarFuncionarios()
        {
            if(funcionarioNum==0)
            {
                cout<<"Nenhum Funcionário Registrado\n";
            }
            else
            {
                cout<<"\nLista de Funcionários Cadastrados: \n";
                for(int i = 0; i<funcionarioNum;i++){
                    Funcionario funcionario = listaFuncionario[i];
                    cout<<"ID: "<<i+1<<" = Nome:"<<funcionario.getNomeFuncionario()<<"\n";
                }
            }
        };
        
        
        void listarQuantidadesProdutos()
        {
            if(produtoNum==0)
            {
                cout<<"\nNenhum Produto Registrado\n";
            }
            else
            {
                cout<<"\nLista de Produtos Cadastrados: \n";
                for(int i = 0; i<produtoNum;i++){
                    Produto produto = listaProduto[i];
                    cout<<"ID: "<<i+1<<" = Nome: "<<produto.getNomeProduto()<<"| Quantidade: "<<produto.getQuantidadeProduto()<<"\n";
                }
            }
        };
        
        void aumentarQuantidadeProduto()
        {
            if(produtoNum==0 || funcionarioNum==0)
            {
                cout<<"Nenhum Produto Registrado\n";
            }
            else
            {
                cout<<"Digite o ID do Produto que você gostaria de aumentar a quantidade: ";
                cin>>idAlteracao;
                
                cout<<"Qual o ID do Funcionário que irá fazer a alteração ? ";
                cin>>idAlteracaoFuncionario;
                
                if(idAlteracao>produtoNum || idAlteracaoFuncionario>funcionarioNum)
                {
                    cout<<"IDs inválidos! Tente outros\n";
                }
                else
                {
                    Produto produto = listaProduto[idAlteracao-1];
                    
                    Funcionario funcionario = listaFuncionario[idAlteracaoFuncionario-1];
                
                    cout<<"Quantas unidades serão adicionadas? ";
                    cin>>numeroAlteracao;
                    numeroAlteracao+=produto.getQuantidadeProduto();
                
                    produto.setQuantidadeProduto(numeroAlteracao);
                    listaProduto[idAlteracao-1] = produto;
                
                    cout<<"Quantidade atualizada por "<<funcionario.getNomeFuncionario()<<" para: "<<produto.getQuantidadeProduto()<<" - "<<produto.getNomeProduto()<<"\n";
                }
            }
        }
        
        void diminuirQuantidadeProduto()
        {
            if(produtoNum==0 || funcionarioNum==0)
            {
                cout<<"Nenhum Produto ou Funcionário Registrado\n";
            }
            else
            {
                cout<<"Digite o ID do Produto que você gostaria de diminuir a quantidade: ";
                cin>>idAlteracao;
                
                cout<<"Qual o ID do Funcionário que irá fazer a alteração ? ";
                cin>>idAlteracaoFuncionario;
                
                if(idAlteracao>produtoNum || idAlteracaoFuncionario>funcionarioNum)
                {
                    cout<<"IDs inválidos! Tente outros\n";
                }
                else
                {
                    Produto produto = listaProduto[idAlteracao-1];
                    
                    Funcionario funcionario = listaFuncionario[idAlteracaoFuncionario-1];
                
                    cout<<"Quantas unidades serão reduzidas? ";
                    cin>>numeroAlteracao;
                
                    if(numeroAlteracao>produto.getQuantidadeProduto())
                    {
                        cout<<"Quantidade de produtos reduzidos inválida! Limite: "<<produto.getQuantidadeProduto()<<"\n";
                    
                    }
                    else
                    {
                        numeroAlteracao=produto.getQuantidadeProduto()-numeroAlteracao;
                        produto.setQuantidadeProduto(numeroAlteracao);
                        listaProduto[idAlteracao-1] = produto;
                        cout<<"Quantidade atualizada por "<<funcionario.getNomeFuncionario()<<" para: "<<produto.getQuantidadeProduto()<<" - "<<produto.getNomeProduto()<<"\n";
                
                    }
                }
            }
        }
    
};


int main()
{
    int option;
    cout<<"Seja bem vindo ao sistema de estoque ! \n";
    Estoque sistemaEstoque;
    
    while(option!=7)
    {
        cout<<"\n Selecione uma função: \n1 -Cadastrar Funcionário \n2 -Cadastrar Produto \n3 -Aumentar Quantidade de Produto no estoque \n4 -Listar Estoque de Produtos \n5 -Listar Funcionários Cadastrados \n6 -Diminuir Quantidade de Produto no estoque \n7 -Sair do Programa de Estoque\n";
        cin>>option;
        
        switch(option){
            case 1:
                sistemaEstoque.cadastrarFuncionario();
                break;
                
            case 2:
                sistemaEstoque.cadastrarProduto();
                break;
        
            case 3:
                sistemaEstoque.aumentarQuantidadeProduto();
                break;
            
            case 4:
                sistemaEstoque.listarQuantidadesProdutos();
                break;
                
            case 5:
                sistemaEstoque.listarFuncionarios();
                break;
                
            case 6:
                sistemaEstoque.diminuirQuantidadeProduto();
                break;
                
            case 7:
                cout<<"ALERTA: Saindo do Programa!!";
                break;
                
            default:
                cout<<"Opção inválida! Digite algum valor listado\n";
                break;
        }
    }
    return 0;
}
