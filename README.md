# transactiontest

[Spring Bootでトランザクション確認試験を行う](https://qiita.com/drafts/60ea681c74188c4ea8bc/edit)用の動作確認ソース。


## API一覧

|         API         |          内容          |
| ------------------- | ---------------------- |
| /employees/list     | 従業員の一覧を取得する |
| /employees/register | 従業員情報を登録する   |


### 実行イメージ

- Spring Bootを起動してからURLにアクセスする

    ~~~url
    http://localhost:8080/employees/list
    ~~~

### /employees/list 


- request

    パラメータなし

- response

    ~~~json
    [Employee(name=森岡 陽介, phone=03-1111-1111, mail=morioka@aa.com)  , Employee(name=浦田 康之, phone=03-1111-1112, mail=urata@aa.com) , Employee(name=大岩 尚人, phone=03-1111-1113, mail=oiwa@aa.com)]
    ~~~


### /employees/register


- request
    - Header Name

        ~~~text
        Content-Type
        ~~~
    - Header Value

        ~~~text
        application/json
        ~~~
    - Body

        ~~~json
        {"name":"日比 隆夫","phone":"123-4345-2352","mail":"hibi@test.com"}
        ~~~


- response  
    従業員登録件数を返却

    ~~~text
    4
    ~~~


