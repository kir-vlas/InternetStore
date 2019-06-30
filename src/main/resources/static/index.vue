<template>
    <div class="container">
        <div id="main">
            <app-header></app-header>
            <app-menu></app-menu>
        </div>
        <div id="left">
            <h2>Categories</h2>
            <div v-if="categories">
                <table class="data">
                    <div v-for="category of categories">
                        <a :href="'/goods/' + category.id">{{category.category}}</a>
                    </div>
                </table>
            </div>
        </div>

        <div id="right">
            <h2>Goods</h2>
            <div v-if="goods">
                <div id="goods">
                    <div v-for="good of goods">
                        <div class="goodsm">
                            <a :href="'/good?id=' + good.id">{{good.title}}</a>
                            <div class="goods-ut">
                                {{good.price}}
                                <button>Add to cart</button>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <app-footer></app-footer>
        <div class="after-add-in-cart">
            Item Added in cart
        </div>
    </div>
</template>

<script>
    import appHeader from './header.vue';
    import appFooter from './footer.vue';
    import appMenu from './menu.vue';

    export default {
        name: 'index',
        components: {appHeader, appFooter, appMenu},
        data() {
            return {
                categories: [],
                goods: [],
            }
        }
    }
</script>

<style>
    .container {
        width: 1200px;
        margin: 0 auto;
        border: 1px solid black;
    }

    #left {
        padding-left: 3px;
        width: 200px;
        float: left;
        height: 100%;
    }

    #right {
        width: 980px;
        height: 100%;
        float: right;
    }

    .after-add-in-cart{
        position: fixed;
        width: 150px;
        height: 50px;
        bottom: 10px;
        padding-left: 10px;
        padding-top: 10px;
        right: 10px;
        display: none;
        z-index: 1;
        border: 1px solid black;
    }
</style>