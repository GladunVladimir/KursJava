<script>
    export let name;
</script>


<div class="container-fluid grid">
    <div class="title">
        <h3>{name}</h3>
    </div>

    <slot name="fields">

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