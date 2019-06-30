<template>
    <div class="hor_menu">
        <div class="hor_left">
            <ul class="hmenu">
                <li>
                    <a href="/cart">Cart</a>
                </li>
                <li>
                    <a>Shipping info</a>
                </li>
            </ul>
        </div>
        <div class="hor_right">
            <div  access="hasRole('ROLE_CLIENT')">
                <ul class="hmenu">
                    <li>
                        <a href="${pageContext.request.contextPath}/clientInfo">
                            Welcome, username
                        </a>
                    </li>
                    <li>
                        <form style="width: 350px; float: right;" action="${pageContext.request.contextPath}/logout" method="POST">
                            <input style="font-size: 10px;" type="submit" value="Logout" />
                        </form>
                    </li>
                </ul>

            </div>
            <div access="hasRole('ROLE_ANONYMOUS')">
                <ul class="hmenu">
                    <li>
                        <a href="${pageContext.request.contextPath}/login">Login</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/register">Register</a>
                    </li>
                </ul>

            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'app-menu'
    }
</script>

<style>
    .hor_menu{
        height: 50px;
        margin-bottom: 10px;
    }

    .hor_left{
        width: 700px;
        float:left;
        border-right:1px solid black;
    }

    .hor_right{
        width:495px;
        float:right;
    }

    ul.hmenu{
        margin:0px;
        padding:10px;
    }

    ul.hmenu li{
        border-right:1px solid #996633;
        padding:3px;
        display: inline;
        text-decoration:none;
    }

    li a{
        text-decoration:none;
        color:black;
    }
</style>