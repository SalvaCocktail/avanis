<style>
    .input-container {
        position: relative;
        border: 1px solid #ccc;
        padding: 10px;
        border-radius: 5px;
        width: 100%;
    }

    #editable<portlet:namespace /> {
        width: 100%;
        height: auto;
        min-height: 60px;
        outline: none;
        overflow-y: auto;
    }

    [contenteditable=true]:empty:before {
        content: attr(placeholder);
        color: #aaa;
    }

    .toolbar {
        display: flex;
        align-items: center;
        gap: 4px;
        margin-top: 5px;
    }

    .icon {
        cursor: pointer;
        font-size: 16px;
        padding: 2px;
    }

    #format-menu {
        display: none;
        position: absolute;
        bottom: -40px;
        left: 40px;
        background: #f9f9f9;
        border: 1px solid #ddd;
        padding: 5px;
        border-radius: 3px;
        box-shadow: 0 2px 5px rgba(0,0,0,0.2);
    }

    #format-menu button {
        border: none;
        background: none;
        cursor: pointer;
        margin: 0 5px;
        font-size: 16px;
        color: #000;
    }

    #format-menu button.active {
        background-color: #ddd;
        border-radius: 3px;
    }

    .menu {
        position: absolute;
        background: #f9f9f9;
        border: 1px solid #ddd;
        padding: 5px;
        border-radius: 3px;
        box-shadow: 0 2px 5px rgba(0,0,0,0.2);
        z-index: 1;
    }

    .icon.active {
        background-color: #ddd;
        border-radius: 3px;
        /*padding: 2px;*/
    }

    .input-container {
        border: 1px solid #101717;
        border-radius: 4px;
        padding: 12px 16px;
        resize: none;
    }

    .loading-spinner {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(255, 255, 255, 0.8);
        display: flex;
        justify-content: center;
        align-items: center;
        z-index: 9999; /* Asegúrate de que esté encima de otros elementos */
    }

    .spinner {
        border: 4px solid rgba(0, 0, 0, 0.1);
        border-left-color: #000;
        border-radius: 50%;
        width: 40px;
        height: 40px;
        animation: spin 1s linear infinite;
    }

    @keyframes spin {
        to { transform: rotate(360deg); }
    }
</style>