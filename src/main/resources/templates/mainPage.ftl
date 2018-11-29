<html>
<head>
<title></title>
</head>
<body>
    <table>
        <#list transactions as transaction>
            <tr>
                <td>${transaction.id}</td>
                <td>${transaction.name}</td>
                <td>${transaction.price}</td>
            </tr>
        </#list>
    </table>
</body>
</html>