package com.darkenedfusion;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		
		getServer().getPluginManager().registerEvents(this, this);
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	/*
	 * All code was created by DarkenedFusion.
	 * 
	 * 
	 */
	
	@EventHandler
	public void onTouch(EntityDamageByEntityEvent event) {
		if(event.getEntity() instanceof Player) {
			
		
		Player player = (Player) event.getEntity();
		if(event.getDamager() instanceof Entity) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 500, 0));
			player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 900, 0));
			player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 900, 0));
			player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 900, 2));
		}
		}
	}
	
	@EventHandler
	public void onEatRaw(PlayerItemConsumeEvent event) {
		if(event.getPlayer() instanceof Player) {
		Player player = event.getPlayer();
		Material item = event.getItem().getType();
		if(item == Material.PORKCHOP) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 0));
		}
		if(item == Material.COD) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 0));
		}
		if(item == Material.SALMON) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 0));
		}
		if(item == Material.TROPICAL_FISH) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 0));
		}
		if(item == Material.CHICKEN) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 0));
		}
		if(item == Material.BEEF) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 0));
		}
		if(item == Material.MUTTON) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 0));
		}
		if(item == Material.RABBIT) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 0));
		}
		if(item == Material.MILK_BUCKET) {
			event.setCancelled(true);
		}
		if(item == Material.APPLE) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 0));
		}
	}
	}
	@EventHandler
	public void inWater(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		Block block = player.getLocation().getBlock();
		if(block.getType() == Material.WATER) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 0));
		}
		if(block.getType() == Material.SOUL_SAND) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 0));
		}
	}
	
	@EventHandler
	public void onZombieSpawn(CreatureSpawnEvent event) {
		if(event.getEntity() instanceof Zombie) {
			Zombie zombie = (Zombie) event.getEntity();
			
			ItemStack HasmatBoots = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta meta = (LeatherArmorMeta) HasmatBoots.getItemMeta();
			meta.setColor(Color.YELLOW);
			HasmatBoots.setItemMeta(meta);
			
			ItemStack HasmatLeggings = new ItemStack(Material.LEATHER_LEGGINGS);
			LeatherArmorMeta meta2 = (LeatherArmorMeta) HasmatLeggings.getItemMeta();
			meta2.setColor(Color.YELLOW);
			HasmatLeggings.setItemMeta(meta2);
			
			ItemStack HasmatChestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta meta3 = (LeatherArmorMeta) HasmatChestplate.getItemMeta();
			meta3.setColor(Color.YELLOW);
			HasmatChestplate.setItemMeta(meta3);
			
				zombie.getEquipment().setHelmet(new ItemStack(Material.YELLOW_STAINED_GLASS));
				zombie.getEquipment().setChestplate(new ItemStack(HasmatChestplate));
				zombie.getEquipment().setLeggings(new ItemStack(HasmatLeggings));
				zombie.getEquipment().setBoots(new ItemStack(HasmatBoots));
				zombie.setCustomName(ChatColor.RED + "Infected");
				zombie.setCustomNameVisible(true);
				zombie.getEquipment().setBootsDropChance(0);
				zombie.getEquipment().setChestplateDropChance(0);
				zombie.getEquipment().setLeggingsDropChance(0);
				zombie.getEquipment().setHelmetDropChance(0);
				
			}
		}
	
	@EventHandler
	public void onZombieDie(EntityDeathEvent event) {
		if(event.getEntity() instanceof Zombie) {
			Zombie zombie = (Zombie) event.getEntity();
				AreaEffectCloud covidcloud = (AreaEffectCloud) zombie.getWorld().spawnEntity(zombie.getLocation(), EntityType.AREA_EFFECT_CLOUD);
				covidcloud.addCustomEffect(new PotionEffect(PotionEffectType.POISON, 500, 0), true);
				covidcloud.setRadius(1);
				covidcloud.setWaitTime(0);
				covidcloud.setDuration(400);
				covidcloud.setCustomName("Covid Cloud");
				covidcloud.setCustomNameVisible(false);
				covidcloud.setParticle(Particle.REDSTONE, new Particle.DustOptions(Color.LIME, 2));
			
		}
	}
	
	double distance = 6;
	Sound sound = null;
	double power = 1;
	
    @EventHandler
    public void socialDistance(PlayerMoveEvent event) {
            Player player = event.getPlayer();
            player.getNearbyEntities(distance, distance, distance).stream().filter(entity -> entity instanceof Player).forEach(otherPlayer -> {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 500, 0));
            });

    }
    
    @EventHandler
    public void nearVillager(PlayerMoveEvent event) {
    	Player player = event.getPlayer();
    	player.getNearbyEntities(6, 6, 6).stream().filter(entity -> entity instanceof Villager).forEach(otherVillager -> {
    		player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 500, 0));
    	});
    }
    
    
    @EventHandler
	public void onSkeletonSpawn(CreatureSpawnEvent event) {
		if(event.getEntity() instanceof Skeleton) {
			Skeleton skeleton = (Skeleton) event.getEntity();
			
			ItemStack HasmatBoots = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta meta = (LeatherArmorMeta) HasmatBoots.getItemMeta();
			meta.setColor(Color.YELLOW);
			HasmatBoots.setItemMeta(meta);
			
			ItemStack HasmatLeggings = new ItemStack(Material.LEATHER_LEGGINGS);
			LeatherArmorMeta meta2 = (LeatherArmorMeta) HasmatLeggings.getItemMeta();
			meta2.setColor(Color.YELLOW);
			HasmatLeggings.setItemMeta(meta2);
			
			ItemStack HasmatChestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta meta3 = (LeatherArmorMeta) HasmatChestplate.getItemMeta();
			meta3.setColor(Color.YELLOW);
			HasmatChestplate.setItemMeta(meta3);
			
			
			skeleton.getEquipment().setHelmet(new ItemStack(Material.YELLOW_STAINED_GLASS));
			skeleton.getEquipment().setChestplate(new ItemStack(HasmatChestplate));
			skeleton.getEquipment().setLeggings(new ItemStack(HasmatLeggings));
			skeleton.getEquipment().setBoots(new ItemStack(HasmatBoots));
			skeleton.setCustomName(ChatColor.RED + "Infected");
			skeleton.setCustomNameVisible(true);
			skeleton.getEquipment().setBootsDropChance(0);
			skeleton.getEquipment().setChestplateDropChance(0);
			skeleton.getEquipment().setLeggingsDropChance(0);
			skeleton.getEquipment().setHelmetDropChance(0);
				
			}
		}
    
    
    @EventHandler
	public void onSkeletonDie(EntityDeathEvent event) {
		if(event.getEntity() instanceof Skeleton) {
			Skeleton skeleton = (Skeleton) event.getEntity();
				AreaEffectCloud covidcloud = (AreaEffectCloud) skeleton.getWorld().spawnEntity(skeleton.getLocation(), EntityType.AREA_EFFECT_CLOUD);
				covidcloud.addCustomEffect(new PotionEffect(PotionEffectType.POISON, 500, 0), true);
				covidcloud.setRadius(1);
				covidcloud.setWaitTime(0);
				covidcloud.setDuration(400);
				covidcloud.setCustomName("CovidCloud");
				covidcloud.setCustomNameVisible(false);
				covidcloud.setParticle(Particle.REDSTONE, new Particle.DustOptions(Color.LIME, 2));
			
		}
	}
    
    @EventHandler
    public void onShootGhast(ProjectileHitEvent event) {
    	if(event.getEntity().getShooter() instanceof Ghast) {
    		Fireball fireball = (Fireball) event.getEntity();
    		if(fireball.isOnGround() || fireball.isDead()) {
    			AreaEffectCloud covidcloud = (AreaEffectCloud) fireball.getWorld().spawnEntity(fireball.getLocation(), EntityType.AREA_EFFECT_CLOUD);
				covidcloud.addCustomEffect(new PotionEffect(PotionEffectType.POISON, 500, 0), true);
				covidcloud.setRadius(5);
				covidcloud.setWaitTime(0);
				covidcloud.setDuration(400);
				covidcloud.setCustomName("CovidCloud");
				covidcloud.setCustomNameVisible(false);
				covidcloud.setParticle(Particle.REDSTONE, new Particle.DustOptions(Color.LIME, 2));
    		}
    	}
    	
    }
    
    
    
    
    

    
}

		
		
		
	
	
	


