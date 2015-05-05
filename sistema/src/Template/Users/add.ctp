<?= $this->element('sidebar'); ?>
<div class="users form large-10 medium-9 columns">
    <?= $this->Form->create($user); ?>
    <fieldset>
        <legend><?= __('Adicionar') ?></legend>
        <?php
            echo $this->Form->input('username', ['label'=>'Email', 'type'=>'email']);
            echo $this->Form->input('password' , ['label'=> 'Senha']);
            echo $this->Form->input('name' , ['label' => 'Nome']);
        ?>
    </fieldset>
    <?= $this->Form->button(__('Salvar')) ?>
    <?= $this->Form->end() ?>
</div>
