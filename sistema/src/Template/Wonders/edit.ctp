<div class="actions columns large-2 medium-3">
    <h3><?= __('Actions') ?></h3>
    <ul class="side-nav">
        <li><?= $this->Form->postLink(
                __('Delete'),
                ['action' => 'delete', $wonder->id],
                ['confirm' => __('Are you sure you want to delete # {0}?', $wonder->id)]
            )
        ?></li>
        <li><?= $this->Html->link(__('List Wonders'), ['action' => 'index']) ?></li>
    </ul>
</div>
<div class="wonders form large-10 medium-9 columns">
     <?= $this->Form->create($wonder); ?>
    <fieldset>
        <legend><?= __('Add Wonder') ?></legend>
        <?php
            echo $this->Form->input('id');
            echo $this->Form->input('name');
            echo $this->Form->input('description');
            echo $this->Form->input('type' , [
                'options' => [
                    'natureza' => 'Natureza',
                    'religiosidade' => 'Religiosidade',
                    'eventos_e_diversao' => 'Eventos e Diversão',
                    'historia_e_cultura' => 'História e Cultura'
                ]
            ]);
        ?>
    </fieldset>
    <fieldset>
        <legend><?= __('Add Address') ?></legend>
        <?php
        echo $this->Form->input('addresses.0.id');
            echo $this->Form->input('addresses.0.city');
            echo $this->Form->input('addresses.0.street');
            echo $this->Form->input('addresses.0.neighborhood');
            echo $this->Form->input('addresses.0.complemento');
            echo $this->Form->input('addresses.0.latitude');
            echo $this->Form->input('addresses.0.longitude');
            echo $this->Form->input('addresses.0.sector');
        ?>
    </fieldset>
    <?= $this->Form->button(__('Submit')) ?>
    <?= $this->Form->end() ?>
</div>
