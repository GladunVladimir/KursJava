<script>
    import {link} from 'svelte-routing';
    export let name;
</script>


<div class="container-fluid grid">
    <div class="title">
        <h3>{name}</h3>
        <a href="{name.toLowerCase()}/create" use:link>Create</a>
    </div>

    <slot name="table">

    </slot>
</div>

<style>
    h3 {
        margin: 0;
    }

    .title {
        display: grid;
        align-content: start;
    }

    .grid {
        display: grid;
        gap: 1em;
    }
</style>