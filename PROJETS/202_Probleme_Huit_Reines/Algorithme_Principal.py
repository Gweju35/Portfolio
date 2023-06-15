# Ce code est l'algorithme principal 
# Ce programme est un algorithme de backtracking qui permet de résoudre le problème des huit reines 
def estValide(echiquier, ligne, colonne):
    """ Vérifie si la case (ligne, colonne) est sûre pour placer une reine """
    # On vérifie la ligne
    for i in range(colonne):
        if echiquier[ligne][i] == 1:
            return False
    # On vérifie la diagonale ascendante
    for i, j in zip(range(ligne, -1, -1), range(colonne, -1, -1)):
        if echiquier[i][j] == 1:
            return False
    # On vérifie la diagonale descendante
    for i, j in zip(range(ligne, len(echiquier)), range(colonne, -1, -1)):
        if echiquier[i][j] == 1:
            return False
    return True

def resoudre_probleme_huit_reines(echiquier, colonne):
    """ Fonction principale pour résoudre le problème des huit reines sur un échiquier de n x n cases """
    solutions = []
    # Si toutes les colonnes ont été parcourues, alors la solution est trouvée
    if colonne == len(echiquier):
        # Ajouter l'échiquier actuel à la liste des solutions
        solution = []
        for ligne in echiquier:
            solution.append(ligne.index(1))
        solutions.append(solution)
        return solutions
    # On place la reine sur chaque ligne possible dans la colonne actuelle
    for i in range(len(echiquier)):
        if estValide(echiquier, i, colonne):
            # On place la reine
            echiquier[i][colonne] = 1
            # On résoud le problème pour la colonne suivante
            solutions.extend(resoudre_probleme_huit_reines(echiquier, colonne + 1))
            # On retire la reine pour explorer d'autres options
            echiquier[i][colonne] = 0
    # On retourne la liste des solutions
    return solutions

# Exemple d'utilisation
solutions = resoudre_probleme_huit_reines([[0]*8 for _ in range(8)], 0)
for echiquier in solutions:
    print(echiquier)
# pour les solutions, on part de la ligne 0 (1 sur l'échiquier) et le chiffre donné correspond à la colonne sur la ligne,
# exemple : [0, 4, 7, 5, 2, 6, 1, 3]
# - sur la ligne 0 colonne 0 il y'a une dame
# - sur la ligne 1 colonne 4 il y a une dame 
# - etc 

